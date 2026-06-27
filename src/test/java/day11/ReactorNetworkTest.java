package day11;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReactorNetworkTest {

    @Test
    void shouldCountPathsFromYouToOut() {
        ReactorNetwork network = new ReactorNetwork(partOneDevices());

        assertEquals(5, network.countPaths("you", "out"));
    }

    @Test
    void shouldCountPathsVisitingBothRequiredDevices() {
        ReactorNetwork network = new ReactorNetwork(partTwoDevices());

        assertEquals(
                2,
                network.countPathsVisitingBoth("svr", "out", "dac", "fft")
        );
    }

    private List<Device> partOneDevices() {
        return List.of(
                Device.from("aaa: you hhh"),
                Device.from("you: bbb ccc"),
                Device.from("bbb: ddd eee"),
                Device.from("ccc: ddd eee fff"),
                Device.from("ddd: ggg"),
                Device.from("eee: out"),
                Device.from("fff: out"),
                Device.from("ggg: out"),
                Device.from("hhh: ccc fff iii"),
                Device.from("iii: out")
        );
    }

    private List<Device> partTwoDevices() {
        return List.of(
                Device.from("svr: aaa bbb"),
                Device.from("aaa: fft"),
                Device.from("fft: ccc"),
                Device.from("bbb: tty"),
                Device.from("tty: ccc"),
                Device.from("ccc: ddd eee"),
                Device.from("ddd: hub"),
                Device.from("hub: fff"),
                Device.from("eee: dac"),
                Device.from("dac: fff"),
                Device.from("fff: ggg hhh"),
                Device.from("ggg: out"),
                Device.from("hhh: out")
        );
    }
}