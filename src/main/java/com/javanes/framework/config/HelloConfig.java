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

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Espacio de configuración usado por el microservicio.
 * 
 * @author mrbitfly
 *
 */
@Configuration
@EnableConfigurationProperties(HelloConfigProperties.class)
public class HelloConfig {
}