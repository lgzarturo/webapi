package com.arthurolg.practices;

import javax.transaction.NotSupportedException;

public interface FelineDomestic extends Feline {
    void meaw() throws NotSupportedException;
}
