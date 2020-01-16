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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javanes.framework.model.ProfileResponse;

/**
 * Controlador REST del servicio profile.
 * 
 * @author mrbitfly
 *
 */
@RestController
@RequestMapping("profile-controller")
@RefreshScope
public class ProfileController {

  /**
   * Ejemplo de declaración del logger para los controladores.
   */
  private static final Logger LOG = LoggerFactory
      .getLogger(ProfileController.class);

  /**
   * Ejemplo de extracción de propiedades las cuales pueden tener un
   * valor por defecto.
   */
  @Value("${spring.profiles.active: default}")
  private String profile;

  /**
   * Ejemplo de una llamada GET al servicio REST representado por
   * este controlador.
   * 
   * @return Respuesta que puede ser mapeada a formato JSON.
   */
  @GetMapping(path = "/active", produces = "application/json")
  public ProfileResponse getActiveEnvironment() {
    ProfileResponse response;

    response = new ProfileResponse();

    response.setEnvironment(profile);
    if (LOG.isDebugEnabled()) {
      LOG.debug("MENSAJE: {}", response.getEnvironment());
    }
    return response;
  }

}