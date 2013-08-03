package com.github.springrest.auth;

import com.github.springrest.model.Authentication;

public interface AuthenticationService {

	public boolean authenticate(Authentication authentication);

}
