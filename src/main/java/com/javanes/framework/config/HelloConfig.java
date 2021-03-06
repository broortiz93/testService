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

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
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
	@ConfigurationProperties(prefix = "spring.datasource")
	@Bean(name = "DataSource")
	public DataSource InformixDataSource() 
	{
		 DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("com.informix.jdbc.IfxDriver");
	        dataSourceBuilder.url("jdbc:informix-sqli://10.26.169.37:21525/bdinteg:INFORMIXSERVER=coppel_tcp");
	        dataSourceBuilder.username("userCppel");
	        dataSourceBuilder.password("C0pp3I_08$wop*w1st6tp6r");
	        return dataSourceBuilder.build();
	}
}
