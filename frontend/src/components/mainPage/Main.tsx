import React from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {Event} from './Event';
import {StoreType} from '../../state/store';
import {loadEvents} from '../../state/actions/mainActions';

export function Main() {
  const dispatch = useDispatch();
  dispatch(loadEvents());
  const events = useSelector((store: StoreType) => store.mainReducer.events);

  return (
    <div className="Main">
      {events.map(item => (
        <>
          <Event {...item} />
        </>
      ))}
    </div>
  );
}
