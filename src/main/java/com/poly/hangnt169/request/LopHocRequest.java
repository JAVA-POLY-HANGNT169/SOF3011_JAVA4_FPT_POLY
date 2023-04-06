package com.poly.hangnt169.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * @author hangnt169
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LopHocRequest {

    private UUID id;

    private String maLop;

    private String tenLop;

    private Integer soLuongSV;

}
