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
  },
});
export const eventListReducer = eventListSlice.reducer;
// Actions
const {eventsLoaded} = eventListSlice.actions;
export const fetchEvents = () => async (dispatch: Dispatch) => {
  const response = await fetch('http://localhost:8080/api/events', {
    credentials: 'include',
  });
  const events = await response.json();

  dispatch(eventsLoaded(events));
};
