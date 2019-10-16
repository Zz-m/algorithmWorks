package cn.denghanxi.s51;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlowNetWorkTest {

    private FlowNetWork tinyFN;

    @Before
    public void before() {
        tinyFN = FlowNetWork.tinyFN();
    }

    @Test
    public void simpleTest() {
        assertEquals(6, tinyFN.v());
        assertEquals(8, tinyFN.e());
    }

}