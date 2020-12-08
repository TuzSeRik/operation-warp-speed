import React, {useEffect} from 'react';
import {useDispatch, useSelector} from 'react-redux';
import {Event} from '../Event/Event';
import {StoreType} from '../../App/store';
import {fetchEvents} from './eventListSlice';
import './EventList.css';

export function EventList() {
  const dispatch = useDispatch();
  const events = useSelector(
    (store: StoreType) => store.eventListReducer.events
  );

  useEffect(() => {
    dispatch(fetchEvents());
  }, [dispatch]);

  return (
    <div className="EventList">
      {events.map(item => (
        <>
          <Event {...item} />
        </>
      ))}
    </div>
  );
}
