import React from 'react';
import {useDispatch} from 'react-redux';
import {startAddingEvent} from './addEventButtonSlice';
import './AddEventButton.css';

export function AddEventButton() {
  const dispatch = useDispatch();

  return (
    <div
      className="AddEventButton"
      onClick={() => dispatch(startAddingEvent())}
    >
      Add Event
    </div>
  );
}
