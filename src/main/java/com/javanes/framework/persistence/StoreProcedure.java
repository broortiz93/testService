package com.javanes.framework.persistence;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.javanes.framework.model.EntityBase;


@Repository
public class StoreProcedure  {
	private JdbcTemplate jdbcTemplate;
	private String BDIsac="bdisac";
	private String BDInteg="bdinteg";
	private String spParametro="sp_obtieneparametro";
	private String spfecha="sp_obtener_fecha";
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
		                      new SqlParameter("siParametro", Types.INTEGER),
		                      new SqlOutParameter("cCodret", Types.CHAR),
		                      new SqlOutParameter("cValor", Types.CHAR));

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

	public void consultaParametros(ByteArrayInputStream byteIn) throws Exception {
		Connection connection = null;
		
		try {
			System.out.println("Inicia SP...");
			connection = jdbcTemplate.getDataSource().getConnection();
	        CallableStatement cstmt = connection.prepareCall("{call "+spParametro+"(?)}");
	        cstmt.setBinaryStream(1, byteIn);
	        cstmt.execute();
	        cstmt.close();
			System.out.println("SP Finalizado...");
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
