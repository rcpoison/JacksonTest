package org.afraid.poison.jacksontest;

import java.util.UUID;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class UUIDAdapter extends XmlAdapter<String, UUID> {

	@Override
	public UUID unmarshal(String s) {
		if (null==s) {
			return null;
		}
		try {
			return UUID.fromString(s);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public String marshal(UUID uuid) {
		if (uuid==null) {
			return null;
		}
		return uuid.toString();

	}
}
