/***********************************************************************
 * Copyright (c) 2017 Javanes Solutions S.A. de C.V. All rights reserved.
 *
 * Licensed under the GNU General Public License, Version 3 (the 
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/gpl-3.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **********************************************************************/
package com.javanes.framework.controller;

import com.javanes.framework.config.HelloConfigProperties;
import com.javanes.framework.model.BaseResponse;
import com.javanes.framework.model.HelloResponse;
import com.javanes.framework.model.ReqBase;
import com.javanes.framework.persistence.IstoreProcedure;
import com.javanes.framework.persistence.StoreProcedure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para llamadas al servicio hello.
 * 
 * @author mrbitfly
 *
 */
@RestController
@RequestMapping("hello-controller")
@RefreshScope
public class HelloController {

  /**
   * Ejemplo de declaración del Logger para un servicio.
   */
  private static final Logger LOG = LoggerFactory
      .getLogger(HelloController.class);

  /**
   * Injección de las propiedades leidas por la infraestructura para
   * poder ser usadas dentro del programa.
   */
  @Autowired
  private HelloConfigProperties helloConfigProperties;

  /**
   * Ejemplo de una llamada GET al servicio REST representado por
   * este controlador.
   * 
   * @return Una clase de respuesta que puede ser mapeada a formato
   * JSON.
   */
  @Autowired 
  private StoreProcedure sp;
  
  @GetMapping(path = "/hello", produces = "application/json")
  public HelloResponse getHello() {
    HelloResponse response;
    response = new HelloResponse();
    response.setMessage(this.helloConfigProperties.getHello());
      LOG.info("MENSAJE: {}", response.getMessage());
    return response;
  }
  @PostMapping(path = "/consultaParm", produces = "application/json")
  @ResponseBody
  public BaseResponse consultaParam(ReqBase req) {
	  
		System.out.println("Consulta Params"+ req.getParamInt());
		BaseResponse resConsulta= new BaseResponse();
		try {
			resConsulta.setParams(sp.getParams(req.getParamInt()));
			resConsulta.setpMensaje("Consulta exitosa");
			
		} catch (Exception e) {
			resConsulta.setpMensaje("Imposible consultar parametros");
		}
	
      LOG.info("MENSAJE: {}", resConsulta.getpMensaje());
    return resConsulta;
  }
  @GetMapping(path = "/consultaParmGet", produces = "application/json")
  public BaseResponse consultaParam() {
	  
		System.out.println("Consulta Params"+ 6001);
		BaseResponse resConsulta= new BaseResponse();
		try {
			resConsulta.setParams(sp.getParams(6001));
			resConsulta.setpMensaje("Consulta exitosa");
			
		} catch (Exception e) {
			resConsulta.setpMensaje("Imposible consultar parametros");
		}
	
      LOG.info("MENSAJE: {}", resConsulta.getpMensaje());
    return resConsulta;
  }
  @GetMapping(path = "/consultaFecha", produces = "application/json")
  public BaseResponse consultaFecha() {
	 BaseResponse resConsulta= new BaseResponse();
		try {
			resConsulta.setParams(sp.getFecha());
			resConsulta.setpMensaje("Consulta de fecha exitosa");
			
		} catch (Exception e) {
			resConsulta.setpMensaje("Imposible consultar fecha");
		}
	
   LOG.info("MENSAJE: {}", resConsulta.getpMensaje());
 return resConsulta;
}

}
