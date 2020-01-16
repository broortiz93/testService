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
package com.javanes.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del microservicio de Hello.
 * 
 * @author mrbitfly
 *
 */
@SpringBootApplication
public class HelloMicroserviceApp {

  /**
   * Método de arranque.
   * 
   * @param args Los argumentos de este método no son usados.
   */
  public static void main(String[] args) {
    SpringApplication.run(HelloMicroserviceApp.class, args);
  }
}
