import {createSlice, Dispatch} from '@reduxjs/toolkit';
// Reducers
const eventAdderSlice = createSlice({
  name: 'eventAdder',
  initialState: {
    summary: '',
    description: '',
    startTimeString: '',
    location: '',
    attendees: '',
  },
  reducers: {
    summaryEdited: (state, action) => {
      state.summary = action.payload;
    },
    descriptionEdited: (state, action) => {
      state.description = action.payload;
    },
    startTimeStringEdited: (state, action) => {
      state.startTimeString = action.payload;
    },
    locationEdited: (state, action) => {
      state.location = action.payload;
    },
    attendeesEdited: (state, action) => {
      state.attendees = action.payload;
    },
  },
});

export const eventAdderReducer = eventAdderSlice.reducer;
// Actions
const {
  summaryEdited,
  descriptionEdited,
  startTimeStringEdited,
  locationEdited,
  attendeesEdited,
} = eventAdderSlice.actions;

export const editSummary = (summary: string) => (dispatch: Dispatch) => {
  dispatch(summaryEdited(summary));
};

export const editDescription = (description: string) => (
  dispatch: Dispatch
) => {
  dispatch(descriptionEdited(description));
};

export const editStartTimeString = (startTimeString: string) => (
  dispatch: Dispatch
) => {
  dispatch(startTimeStringEdited(startTimeString));
};

export const editLocation = (location: string) => (dispatch: Dispatch) => {
  dispatch(locationEdited(location));
};

export const editAttendees = (attendees: string[]) => (dispatch: Dispatch) => {
  dispatch(attendeesEdited(attendees));
};
