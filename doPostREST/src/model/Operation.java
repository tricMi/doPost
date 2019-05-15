package model;

import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public enum Operation {

    MOVE, COPY, DELETE
}
