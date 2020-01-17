package com.javanes.framework.persistence;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.javanes.framework.model.EntityBase;
import org.springframework.jdbc.core.SqlReturnResultSet;


@Repository
public class StoreProcedure  {
	private JdbcTemplate jdbcTemplate;
	private String BDIsac="bdisac:informix";
	private String BDInteg="bdinteg:informix";
	private String spParametro="sp_obtieneparametro";
	private String spfecha="sp_obtener_fecha";
	private String spPagoServicio="sp_pago_servicios";
	  private static final Logger LOG = LoggerFactory
		      .getLogger(StoreProcedure.class);

	@Resource(name="DataSource")
	public final void setDataSource(final DataSource dataSource) {
	       this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public EntityBase getParams(Integer id) throws Exception {
		try {
			LOG.info("Init param :::::::::::: "+id);
			SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(jdbcTemplate).withSchemaName(BDIsac).withProcedureName(spParametro).declareParameters(
		                      new SqlParameter("siParametro", Types.INTEGER));
			jdbcCall.declareParameters(new SqlReturnResultSet("result", new ResultSetExtractor<Map<String, Object>>() {
				@Override
				public  Map<String, Object>  extractData(ResultSet resultSet) throws SQLException {
					Map<String, Object> map = null;
			            
			        while(resultSet.next()) {
			        	map = new HashMap<String, Object>();
			            map.put("cCodret", resultSet.getString(1));
			            map.put("cValor", resultSet.getString(2));
			        }
			        	
			        return map;
			    }
			 }));
			 
			jdbcCall.compile();

			SqlParameterSource in = new MapSqlParameterSource().addValue("siParametro", id);
			Map<String, Object> out = jdbcCall.execute(in);

			out.entrySet().forEach(System.out::println);
			EntityBase student = new EntityBase();
			student.setCodReturn((String) out.get("cCodret"));
			student.setCodValor((String) out.get("cValor"));
			return student;      
		} catch (Exception e) {
			LOG.info("intentando getParams "+e);
			throw new Exception("Error al ejecutar SP");
		}
	}

	
	public EntityBase getParams2(Integer id) throws Exception {
		try {
			LOG.info("Init param :::::::::::: "+id);
			SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(jdbcTemplate).withSchemaName(BDIsac).withProcedureName(spParametro).declareParameters(
		                      new SqlParameter("siParametro", Types.INTEGER));

			SqlParameterSource in = new MapSqlParameterSource().addValue("siParametro", id);
			Map<String, Object> out = jdbcCall.execute(in);
			
			
			
			LOG.info("OOOUUUTTT: "+out.get("#result-set-1"));
			LOG.info("OOOUUUTTT: "+out.get("#result-set-2"));
//			out.entrySet().forEach(System.out::println);
			EntityBase student = new EntityBase();
			student.setCodReturn((String) out.get("cCodret"));
			student.setCodValor((String) out.get("cValor"));
			return student;      
		} catch (Exception e) {
			LOG.info("intentando getParams "+e);
			throw new Exception("Error al ejecutar SP");
		}
	}

	public EntityBase getFecha() throws Exception {
		try {
			LOG.info("Init Fecha:::::::::::::: ");
			SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(jdbcTemplate).withSchemaName(BDInteg).withProcedureName(spfecha).
					declareParameters(  new SqlOutParameter("vFecha", Types.DATE));

			Map<String, Object> out = jdbcCall.execute();
			EntityBase base = new EntityBase();
			base.setFecha((String) out.get("vFecha"));
			out.entrySet().forEach(System.out::println);
			LOG.info("Fecha:::::::::::::: "+base.getFecha());
			return base;      
		} catch (Exception e) {
			throw new Exception("Error al ejecutar SP");
		}
	}

	public void consultaParametros() throws Exception {
		Connection connection = null;
		
		try {
			System.out.println("Inicia SP...");
			connection = jdbcTemplate.getDataSource().getConnection();
	        CallableStatement cstmt = connection.prepareCall("{? = call "+BDIsac+"."+spParametro+"(?)}");
	        cstmt.setInt("siParametro", 6001);
	        cstmt.registerOutParameter(1, Types.CHAR);
	        cstmt.registerOutParameter(2, Types.CHAR);
	        cstmt.executeQuery();
	        cstmt.close();
			System.out.println("SP Finalizado..."+cstmt.getString("cCodret"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		if(connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
			e.printStackTrace();
			}
		}
		
	}


}
