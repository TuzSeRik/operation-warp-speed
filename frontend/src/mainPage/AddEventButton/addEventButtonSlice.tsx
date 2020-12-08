import {createSlice, Dispatch} from '@reduxjs/toolkit';
// Reducers
const addEventButtonSlice = createSlice({
  name: 'addEventButton',
  initialState: {
    isAddingEvent: false,
  },
  reducers: {
    toggleAddingEvent: (state, action) => {
      state.isAddingEvent = action.payload;
    },
  },
});

export const addEventButtonReducer = addEventButtonSlice.reducer;
// Actions
const {toggleAddingEvent} = addEventButtonSlice.actions;

export const startAddingEvent = () => (dispatch: Dispatch) => {
  dispatch(toggleAddingEvent(true));
};

export const cancelEditingEvent = () => (dispatch: Dispatch) => {
  dispatch(toggleAddingEvent(false));
};
