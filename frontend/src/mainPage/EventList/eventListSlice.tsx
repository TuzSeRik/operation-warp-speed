import {createSlice, Dispatch} from '@reduxjs/toolkit';
// Reducers
const eventListSlice = createSlice({
  name: 'eventList',
  initialState: {
    events: [],
  },
  reducers: {
    eventsLoaded: (state, action) => {
      state.events = action.payload;
    },
    eventAdded: (state, action) => {
      state.events.concat(action.payload);
      state.events.sort();
    },
  },
});

export const eventListReducer = eventListSlice.reducer;
// Actions
const {eventsLoaded, eventAdded} = eventListSlice.actions;

export const fetchEvents = () => async (dispatch: Dispatch) => {
  const response = await fetch('http://localhost:8080/api/events', {
    credentials: 'include',
  });
  const events = await response.json();

  dispatch(eventsLoaded(events));
};

export const addEvent = (event: object) => async (dispatch: Dispatch) => {
  const response = await fetch('http://localhost:8080/api/event', {
    method: 'POST',
    credentials: 'include',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(event),
  });
  const receivedEvent = await response.json();

  dispatch(eventAdded(receivedEvent));
};
