package examples.c4e1;

import classes.Artist;

import java.util.stream.Stream;

public interface Perfomance {
    String getName();
    Stream<Artist> getMusicians();
    default Stream<Artist> getAllMusicians() {
        return getMusicians().flatMap(
                artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    }
}
