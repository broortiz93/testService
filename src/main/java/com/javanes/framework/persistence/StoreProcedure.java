package com.javanes.framework.persistence;

import java.io.ByteArrayInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
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
	
	public EntityBase spPagoServicios() throws Exception {
		try {
			SimpleJdbcCall jdbcCall = new 
					SimpleJdbcCall(jdbcTemplate).withSchemaName(BDIsac).withProcedureName(spPagoServicio).declareParameters(
		                      new SqlParameter("pEmpresa", Types.CHAR),new SqlParameter("pSucursal", Types.CHAR),new SqlParameter("pUsuario", Types.CHAR),
		                      new SqlParameter("pTransCargo", Types.CHAR),new SqlParameter("pTransAbono", Types.CHAR),new SqlParameter("pTransSuc", Types.CHAR),
		                      new SqlParameter("pFolioSuc", Types.CHAR),new SqlParameter("pNumCtaOrigen", Types.CHAR),new SqlParameter("pNumCtaDestino", Types.CHAR),
		                      new SqlParameter("pCheque", Types.INTEGER),new SqlParameter("pMonto", Types.NUMERIC),new SqlParameter("pMoneda", Types.CHAR),
		                      new SqlParameter("pReferencia", Types.CHAR),new SqlParameter("pNumTarjetaOrigen", Types.CHAR),new SqlParameter("pNumTarjetaDestino", Types.CHAR),
		                      new SqlParameter("pUsuAutoriza", Types.CHAR),new SqlParameter("pMontoTotal", Types.NUMERIC),new SqlParameter("pMontoFirme", Types.NUMERIC),
		                      new SqlParameter("pMontoSBC", Types.NUMERIC),new SqlParameter("pMontoRem", Types.NUMERIC),new SqlParameter("pDiasRet", Types.SMALLINT),
		                      new SqlParameter("pDocto", Types.INTEGER),new SqlParameter("pCategoria", Types.CHAR),new SqlParameter("pConvenio", Types.CHAR),
		                      new SqlParameter("cRefTelefono", Types.CHAR),new SqlParameter("cRefVerificador", Types.CHAR),new SqlParameter("cFormaPago", Types.CHAR),
		                      new SqlParameter("cCuentaCargo", Types.CHAR),new SqlParameter("cTransacc_suc", Types.CHAR),new SqlParameter("dFechaPago", Types.DATE)
		                      );
			jdbcCall.declareParameters(new SqlReturnResultSet("result", new ResultSetExtractor<Map<String, Object>>() {
				@Override
				public  Map<String, Object>  extractData(ResultSet resultSet) throws SQLException {
					Map<String, Object> map = null;
			        while(resultSet.next()) {
			        	map = new HashMap<String, Object>();
			            map.put("vcodret", resultSet.getString(1));
			            map.put("vcodretRev", resultSet.getString(2));
			        }
			        return map;
			    }
			 }));
			 
			jdbcCall.compile();

			
			SqlParameterSource in = new MapSqlParameterSource().addValue("pEmpresa", "001").addValue("pSucursal", "5003").addValue("pUsuario", "transBPI")
					.addValue("pTransCargo", "1137").addValue("pTransAbono", "1167").addValue("pTransSuc", "8651")
					.addValue("pFolioSuc", "0158467718274728").addValue("pNumCtaOrigen", "12000872207").addValue("pNumCtaDestino", "99010000056")
					.addValue("pCheque", 0).addValue("pMonto", 299.00).addValue("pMoneda", "01")
					.addValue("pReferencia", "501177161582 VETEVE").addValue("pNumTarjetaOrigen", "").addValue("pNumTarjetaDestino", "")
					.addValue("pUsuAutoriza", "").addValue("pMontoTotal", 299.00).addValue("pMontoFirme", 299.00)
					.addValue("pMontoSBC", 0).addValue("pMontoRem", 0).addValue("pDiasRet", 0)
					.addValue("pDocto", 0).addValue("pCategoria", "06").addValue("pConvenio", "001")
					.addValue("cRefTelefono", "501177161582").addValue("cRefVerificador", "2").addValue("cFormaPago", "2")
					.addValue("cCuentaCargo", "12000872207").addValue("cTransacc_suc", "8651").addValue("dFechaPago", new Date("2020/01/16"));
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
}
