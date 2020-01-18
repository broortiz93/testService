package com.javanes.framework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javanes.framework.model.BaseResponse;
import com.javanes.framework.model.EntityBase;
import com.javanes.framework.model.PagoServicio;
import com.javanes.framework.persistence.StoreProcedure;



@RestController
@RequestMapping("servicios-controller")
@RefreshScope
public class PagoServiciosController {

	@Autowired 
	private StoreProcedure bdisac;
	private static final Logger LOG = LoggerFactory
			.getLogger(PagoServiciosController.class);

	@PostMapping(path = "/realizaPagoSky", produces = "application/json")
	@ResponseBody
	public BaseResponse pagoServicio(@RequestBody PagoServicio pagoServicio) {
		BaseResponse resConsulta= new BaseResponse();
		try {
			pagoServicio.setpCategoria("06");
			pagoServicio.setcRefVerificador(pagoServicio.getcRefTelefono().substring(pagoServicio.getcRefTelefono().length() - 1));
			pagoServicio.setpTransSuc("8651");
			pagoServicio.setpConvenio("001");
			pagoServicio.setCuentaServicio(6001);
			pagoServicio.setOperacionServicio("1021");

			EntityBase resultado = bdisac.spPagoServicios(pagoServicio);
			resConsulta.setParams(resultado);
			if(resultado.getCodReturn().equals("00000"))
				resConsulta.setpMensaje("Pago de servicio SKY realizado con éxito");
			else
				resConsulta.setpMensaje("Error al realizar el pago de servicio SKY");


		} catch (Exception e) {
			resConsulta.setpMensaje("No fue posible realizar el pago de servicio");
		}

		LOG.info("MENSAJE: {}", resConsulta.getpMensaje());
		return resConsulta;
	}
}
