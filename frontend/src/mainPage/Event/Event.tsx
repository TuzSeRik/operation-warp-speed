import React from 'react';
import {Container, Row, Col} from 'react-bootstrap';
import './Event.css';

export function Event(event: {
  summary: string;
  description: string;
  startTimeString: string;
  location: string;
  attendees: string[];
}) {
  return (
    <Container className="Event">
      <Row className="EventRow">
        <span className="EventTitle">{event.summary}</span>
      </Row>
      <Row className="EventRow">
        <span className="EventDescription">{event.description}</span>
      </Row>
      <Row className="EventRow">
        <Col className="EventCol" lg={4}>
          <span className="EventTime">{event.startTimeString}</span>
        </Col>
        <Col className="EventCol" lg={8}>
          <span className="EventLocation">{event.location}</span>
        </Col>
      </Row>
      <Row className="EventRow">
        <span className="EventAttendees">{event.attendees}</span>
      </Row>
    </Container>
  );
}
