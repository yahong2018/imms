package com.zhxh.imms.bus;

import com.zhxh.core.data.Entity;
import com.zhxh.core.data.meta.annotation.CheckUnique;
import com.zhxh.core.data.meta.annotation.DataTableConfiguration;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@DataTableConfiguration("bus_message")
@Getter @Setter
public class BusMessage extends Entity<Long> {
    @NotEmpty
    @CheckUnique
    private String messageId;
    @NotEmpty
    private String messageType;
    @NotEmpty
    private String messageBody;
}
