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
package com.javanes.framework.model;

/**
 * Ejemplo de respuesta de POJO mapeable a JSON.
 * 
 * @author mrbitfly
 *
 */
public class ProfileResponse {

  private String environment;

  /**
   * @return the environment
   */
  public String getEnvironment() {
    return environment;
  }

  /**
   * @param environment the environment to set
   */
  public void setEnvironment(String environment) {
    this.environment = environment;
  }
}
