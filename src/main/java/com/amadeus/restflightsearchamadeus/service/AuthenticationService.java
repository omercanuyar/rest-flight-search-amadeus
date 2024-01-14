package com.amadeus.restflightsearchamadeus.service;

import com.amadeus.restflightsearchamadeus.dto.JwtAuthenticationResponse;
import com.amadeus.restflightsearchamadeus.dto.RefreshTokenRequest;
import com.amadeus.restflightsearchamadeus.dto.SignInRequest;
import com.amadeus.restflightsearchamadeus.dto.SignUpRequest;
import com.amadeus.restflightsearchamadeus.model.User;

public interface AuthenticationService {
    User signUp(SignUpRequest signUpRequest);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
