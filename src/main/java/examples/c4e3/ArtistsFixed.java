package examples.c4e3;

import classes.Artist;

import java.util.List;
import java.util.Optional;

public class ArtistsFixed {
    private List<Artist> artists;

    public ArtistsFixed(List<Artist> artists) {
        this.artists = artists;
    }

    public Optional<Artist> getArtist(int index) {   //совпал с ответом один в один
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {        //мой вариант, возможно неверный
        Optional<Artist> artist = getArtist(index);
        if (artist.isPresent()) {
            return artist.get().getName();
        }
        return "unknown";
    }

    public String getArtistNameFA(int index) {      //из ответов
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName)
                     .orElse("unknown");
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index + " doesn't correspond to an Artist");
    }
}
