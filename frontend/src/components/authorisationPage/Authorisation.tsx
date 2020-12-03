import React from 'react';
import {Col, Container, Row} from 'react-bootstrap';
import {Advertisement} from './Advertisement';
import {Login} from './Login';

export function Authorisation() {
  return (
    <Container>
      <Row>
        <Col lg={8}>
          <Advertisement />
        </Col>
        <Col lg={4}>
          <Login />
        </Col>
      </Row>
    </Container>
  );
}
