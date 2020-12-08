import React from 'react';
import {Image} from 'react-bootstrap';
import advertisement from '../../assets/advertisement-1.svg';
import './Advertisement.css';

export function Advertisement() {
  return <Image className="Advertisement" src={advertisement} />;
}
