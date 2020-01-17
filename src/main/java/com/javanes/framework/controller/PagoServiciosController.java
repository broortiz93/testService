package com.javanes.framework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javanes.framework.model.BaseResponse;
import com.javanes.framework.persistence.StoreProcedure;



@RestController
@RequestMapping("servicios-controller")
@RefreshScope
public class PagoServiciosController {
	
	@Autowired 
	private StoreProcedure bdisac;
	  private static final Logger LOG = LoggerFactory
		      .getLogger(PagoServiciosController.class);

	@PostMapping(path = "/realizaPago", produces = "application/json")
	  public BaseResponse pagoServicio() {
		 BaseResponse resConsulta= new BaseResponse();
			try {
				resConsulta.setParams(bdisac.spPagoServicios());
				resConsulta.setpMensaje("Pago de servicio realizado con éxito");
				
			} catch (Exception e) {
				resConsulta.setpMensaje("No fue posible realizar el pago de servicio");
			}
		
	   LOG.info("MENSAJE: {}", resConsulta.getpMensaje());
	 return resConsulta;
	}
}
