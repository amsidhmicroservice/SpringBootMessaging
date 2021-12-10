package com.amsidh.mvc.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageBody implements Serializable {
	private static final long serialVersionUID = -4548121516216571253L;
	private Integer messageId;
	private String filePath;

}
