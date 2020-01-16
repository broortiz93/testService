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
package com.javanes.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Clase con las propiedades de configuración de la clase Hello,
 * por defecto dentro del archivo application-xxx.properties se ha
 * decidido que todas aquellas que inicien con el prefijo "custom"
 * pueden ser parseadas con esta clase siempre y cuando tengan una
 * propiedad equivalente.
 * 
 * Ejemplo:
 * custom.hello=Hello
 * 
 * Será leido por esta clase en la propiedad hello.
 * 
 * @author mrbitfly
 *
 */
@Component
@ConfigurationProperties(prefix = "custom")
public class HelloConfigProperties {
  /**
   * Propiedad hello.
   */
  private String hello;

  /**
   * @return the hello
   */
  public String getHello() {
    return hello;
  }

  /**
   * @param hello the hello to set
   */
  public void setHello(String hello) {
    this.hello = hello;
  }

}