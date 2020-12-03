import {SET_EVENTS} from './actionTypes';
import {Dispatch} from 'redux';
import {EventType} from '../store';

export const loadEvents = () => async (dispatch: Dispatch) => {
  const res = await fetch('http://localhost:8080/api/events');
  const events = await res.json();
  console.log(events);
  dispatch(dispatchLoadedEvents(events));
};

const dispatchLoadedEvents = (events: EventType[]) => {
  return {
    type: SET_EVENTS,
    payload: events,
  };
};
