package com.abdoxm.xelops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class CubeTest {

        @Test
        public void testGetVolume() throws Exception {
            Cube cube = new Cube(10);

            assertEquals(1000, cube.getVolume());
        }

        @Test
        public void testGetSurfaceArea() throws Exception {
            Cube cube = new Cube(5);

            assertEquals(150, cube.getSurfaceArea(), 0.01);
        }
    }
