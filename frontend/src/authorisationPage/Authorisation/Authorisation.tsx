import React from 'react';
import {Container, Row, Col} from 'react-bootstrap';
import {Advertisement} from '../../commonComponents/Advertisement/Advertisement';
import {Login} from '../Login/Login';

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
