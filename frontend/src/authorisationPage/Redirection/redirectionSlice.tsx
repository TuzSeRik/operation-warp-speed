import {createSlice, Dispatch} from '@reduxjs/toolkit';
// Reducers
const redirectionSlice = createSlice({
  name: 'authorisation',
  initialState: {
    isAuthorised: false,
  },
  reducers: {
    loginSuccess: (state, action) => {
      state.isAuthorised = action.payload;
    },
    loginFailure: (state, action) => {
      state.isAuthorised = action.payload;
    },
  },
});
export const redirectionReducer = redirectionSlice.reducer;
// Actions
const {loginSuccess, loginFailure} = redirectionSlice.actions;
export const redirection = (response: string) => (dispatch: Dispatch) => {
  if (response === '?status=ok') {
    dispatch(loginSuccess(true));
  } else {
    dispatch(loginFailure(false));
  }
};
