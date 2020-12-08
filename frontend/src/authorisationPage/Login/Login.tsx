import React from 'react';
import {Container, Row} from 'react-bootstrap';
import GoogleButton from 'react-google-button';
import {useSelector} from 'react-redux';
import {StoreType} from '../../App/store';
import {OAUTH2_ADDRESS} from '../../constants';
import './Login.css';

export function Login() {
  const isAuthorised = useSelector(
    (state: StoreType) => state.redirectionReducer.isAuthorised
  );

  return (
    <Container className="Login">
      <Row className="LoginRow">
        <GoogleButton
          className="LoginButton"
          label="Continue with Google"
          onClick={() => {
            !isAuthorised
              ? (window.location.href = OAUTH2_ADDRESS)
              : (window.location.href = '/main');
          }}
        />
      </Row>
    </Container>
  );
}
