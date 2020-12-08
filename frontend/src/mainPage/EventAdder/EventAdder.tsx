import React from 'react';
import {Form, Button} from 'react-bootstrap';
import {useDispatch, useSelector} from 'react-redux';
import {StoreType} from '../../App/store';
import {
  editAttendees,
  editDescription,
  editLocation,
  editStartTimeString,
  editSummary,
} from './eventAdderSlice';
import './EventAdder.css';
import {cancelEditingEvent} from '../AddEventButton/addEventButtonSlice';
import {addEvent} from '../EventList/eventListSlice';

export function EventAdder() {
  const {
    summary,
    description,
    startTimeString,
    location,
    attendees,
  } = useSelector((state: StoreType) => state.eventAdderReducer);

  const dispatch = useDispatch();

  return (
    <Form className="EventAdder">
      <Form.Group>
        <Form.Label>Event title</Form.Label>
        <Form.Control
          className="EventAdderTitle"
          name="summary"
          type="text"
          value={summary}
          onChange={event => dispatch(editSummary(event.target.value))}
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>Event description</Form.Label>
        <Form.Control
          className="EventAdderDescription"
          name="description"
          type="textarea"
          value={description}
          onChange={event => dispatch(editDescription(event.target.value))}
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>Event start time</Form.Label>
        <Form.Control
          className="EventAdderTime"
          name="time"
          type="text"
          value={startTimeString}
          onChange={event => dispatch(editStartTimeString(event.target.value))}
        />
      </Form.Group>
      <Form.Group>
        <Form.Label>Event location</Form.Label>
        <Form.Control
          className="EventAdderLocation"
          name="location"
          type="text"
          value={location}
          onChange={event => dispatch(editLocation(event.target.value))}
        />
      </Form.Group>
      <Form.Group>
        <Form.Group>Event attendees</Form.Group>
        <Form.Control
          className="EventAdderAttendees"
          name="attendees"
          type="text"
          value={attendees}
          onChange={event => dispatch(editAttendees([event.target.value]))}
        />
      </Form.Group>
      <Form.Group>
        <Button
          onClick={() =>
            dispatch(
              addEvent({
                summary,
                description,
                startTimeString,
                location,
                attendees,
              })
            )
          }
        >
          Add event
        </Button>
        <Button onClick={() => dispatch(cancelEditingEvent())}>
          Cancel adding
        </Button>
      </Form.Group>
    </Form>
  );
}
