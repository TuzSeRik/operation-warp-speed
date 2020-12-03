import React from 'react';
import {Container, Row} from 'react-bootstrap';
import GoogleButton from 'react-google-button';
import {OAUTH2_ADDRESS} from '../App';
import './Login.css';

export function Login() {
  return (
    <Container className="Login">
      <Row className="LoginRow">
        <GoogleButton
          className="LoginButton"
          label="Continue with Google"
          onClick={() => {
            window.location.href = OAUTH2_ADDRESS;
          }}
        />
      </Row>
    </Container>
  );
}
