package org.afraid.poison.jacksontest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Collection;
import java.util.UUID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
public class TestEntity {

	private Collection<UUID> uuids;

	@JsonDeserialize(contentUsing = UUIDDeserializer.class)
	@XmlJavaTypeAdapter(UUIDAdapter.class)
	public Collection<UUID> getUuids() {
		return uuids;
	}

	public void setUuids(Collection<UUID> uuids) {
		this.uuids=uuids;
	}
}
