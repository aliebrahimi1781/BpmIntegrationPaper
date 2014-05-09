package org.bpmintegrationpaper.taskservice.authentication;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.bpmintegrationpaper.dto.DocumentBpmDto;

/**
 * @author Ramon Rosa da Silva (neoramon@gmail.com)
 * @since 1.0.0 07/05/2014
 */
public class AuthenticationService implements JavaDelegate {

    @Override
    public void execute(final DelegateExecution exec) throws Exception {
	final DocumentBpmDto dto = new DocumentBpmDto(exec.getVariables());
	final String user = dto.getUser() + "";
	final String password = dto.getPassword() + "";
	dto.setPassword(null);
	Boolean authenticated = false;
	if ("distributor_x".equals(user) && "xpto".equals(password)) {
	    authenticated = true;
	} else if ("distributor_y".equals(user) && "xpto".equals(password)) {
	    authenticated = true;
	}
	if ("distributor_w".equals(user) && "xpto".equals(password)) {
	    authenticated = true;
	}
	dto.setIsAuthenticated(authenticated);
	exec.setVariables(dto);
    }
}
