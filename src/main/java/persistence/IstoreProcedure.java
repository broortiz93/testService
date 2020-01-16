package persistence;

import java.io.ByteArrayInputStream;

import com.javanes.framework.model.EntityBase;


public interface IstoreProcedure {
	 void consultaParametros(ByteArrayInputStream byteIn )throws Exception ;
	 EntityBase getParams(Integer id) throws Exception;
	 EntityBase getFecha() throws Exception ;
}
