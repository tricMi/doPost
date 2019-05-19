package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum Operation {
	MOVE, COPY, DELETE
}
