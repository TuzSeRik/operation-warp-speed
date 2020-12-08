import React from 'react';
import {useSelector} from 'react-redux';
import {StoreType} from '../../App/store';
import {AddEventButton} from '../AddEventButton/AddEventButton';
import {EventAdder} from '../EventAdder/EventAdder';
import {EventList} from '../EventList/EventList';
import './Main.css';

export function Main() {
  const isAddingEvent = useSelector(
    (state: StoreType) => state.addEventButtonReducer.isAddingEvent
  );

  return (
    <div className="Main">
      {isAddingEvent ? <EventAdder /> : <AddEventButton />}
      <EventList />
    </div>
  );
}
