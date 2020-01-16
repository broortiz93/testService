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

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuración de Swagger para ofrecer un api documentada a los
 * clientes de este microservicio.
 * 
 * @author mrbitfly
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * Proporciona la configuración de los paquetes que serán escaneados
   * para generar un API para los clientes de este servicio.
   * 
   * @return Un Docklet con la configuración por defecto.
   */
  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.javanes.framework"))
        .paths(PathSelectors.regex("/.*")).build().apiInfo(apiEndPointsInfo());
  }

  /**
   * Configuración general para los puntos de acceso al API.
   * 
   * @return Configuración general de los puntos de acceso.
   */
  private ApiInfo apiEndPointsInfo() {
    return new ApiInfoBuilder().title("JSO :: FWK :: Hello :: Service")
        .description("Servicio Hello de ejeplo de Spring Boot")
        .contact(new Contact("Javanes Solutions S.A. de C.V.",
            "www.javanes.com", "info@javanes.com"))
        .license("Apache 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .version("0.0.1").build();
  }
}
