import React from 'react';
import {Container, Row, Col} from 'react-bootstrap';
import {EventType} from '../../state/store';

export function Event(event: EventType) {
  return (
    <Container className="Event">
      <Row className="EventRow">
        <span>{event.description}</span>
      </Row>
      <Row className="EventRow">
        <Col>
          <span>{event.startTimeString}</span>
        </Col>
        <Col>
          <span>{event.location}</span>
        </Col>
      </Row>
      <Row className="EventRow">
        <span>{event.attendees}</span>
      </Row>
    </Container>
  );
}
