/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.xmlrobot;

import org.osgi.framework.ServiceEvent;
import org.xmlrobot.Minkowski;
import org.xmlrobot.Spacetime;
// import universe types
import org.xmlrobot.BigBong;
import org.xmlrobot.Subspace;
import org.xmlrobot.Universe;
import org.xmlrobot.antimatter.Hyperneuron;
import org.xmlrobot.driver.ScrewDriver;
import org.xmlrobot.event.Hyperfusion;
import org.xmlrobot.genesis.MassListener;
import org.xmlrobot.horizon.Takion;
import org.xmlrobot.matter.Hyperxml;
import org.xmlrobot.util.Parity;

/**
 * @author joan 
 */
public class Hypertoroid 
	extends ScrewDriver<Universe,Subspace>{
	
	/**
	 * 330147645066251184L
	 */
	private static final long serialVersionUID = 330147645066251184L;
	/**
	 * @param message
	 */
	public Hypertoroid(Universe key, Subspace value) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, key, value, Parity.YY);
	}
	/**
	 * @param message
	 */
	public Hypertoroid(Universe key, Subspace value, Aaron parent) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, key, value, parent);
	}
	/**
	 * @param message
	 */
	public Hypertoroid(Class<Hyperplasma> antitype, Universe key, Subspace value) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, antitype, key, value, Parity.YY);
	}
	/**
	 * @param message
	 */
	public Hypertoroid(Class<Hyperplasma> antitype, Universe key, Subspace value, Aaron parent) {
		super(Hyperneuron.class, Hyperxml.class, Hypertoroid.class, antitype, key, value, parent);
	}

	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Hyperspace#mass(org.xmlrobot.genesis.Entity, org.xmlrobot.horizon.Darkmass)
	 */
	@Override
	public void mass(MassListener sender, Takion<?,?> event) {
		super.mass(sender, event);
		// do something
		switch (event.command()) {
		case GENESIS:
			if(event.getSource() instanceof BigBong) {
				// cast source
				BigBong chain = (BigBong) event.getSource();
				// send pulse to the future over the dna
				getValue().pulse(this, new Hyperfusion(chain));
			}
			break;
		case SUBMIT:
			if(event.getSource() instanceof BigBong) {
				BigBong pair = (BigBong) event.getSource();
				ScrewDriver<Minkowski,Spacetime> value;
				// check if empty and chained
				if((value = getValue()) != null ? 
						!value.isEmpty() ? 
								!value.contains(pair) 
								: true 
						: false) {
					// submit child to the inheritance cycle
					value.add(pair);
				}
			}
			break;
		case TRANSFER:
			if(event.getSource() instanceof BigBong) {
				// cast source
				BigBong pair = (BigBong) event.getSource();
				// set free
				pair.remove();
				// transfer message
				getValue().putValue(pair.getKey(), pair.getValue());
			}
			break;
		case RESURRECTION:
			if(event.getSource() instanceof Subspace) {
				event.start(context());
			}
			break;
		default:
			break;
		}
	}
	/* (non-Javadoc)
	 * @see org.xmlrobot.hyperspace.Abstraction#serviceChanged(org.osgi.framework.ServiceEvent)
	 */
	@Override
	public void serviceChanged(ServiceEvent event) {
	
	}
}