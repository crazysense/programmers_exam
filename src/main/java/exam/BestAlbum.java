package exam;

import java.util.*;

// 베스트 앨범
// 노래 장르
// 플레이 횟수
public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop" };
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution1(genres, plays)));
    }

    static int[] solution1(String[] genres, int[] plays) {
        Map<String, List<Music>> musicMap = groupByGenres(genres, plays);
        List<BestGenres> musicList = sortByPlays(musicMap);

        int size = 0;
        for (BestGenres bestGenres : musicList) {
            if (bestGenres.musicList.size() >= 2) {
                size += 2;
            } else {
                size += 1;
            }
        }

        int[] result = new int[size];
        int idx = 0;
        for (BestGenres bestGenres : musicList) {
            for (int i = 0; i < bestGenres.musicList.size() && i < 2; i++) {
                result[idx++] = bestGenres.musicList.get(i).id;
            }
        }

        return result;
    }

    private static Map<String, List<Music>> groupByGenres(String[] genres, int[] plays) {
        Map<String, List<Music>> musicMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            Music m = new Music(genres[i], plays[i], i);
            List<Music> musicList = musicMap.get(m.genres);
            if (musicList == null) {
                musicList = new ArrayList<>();
                musicMap.put(m.genres, musicList);
            }
            musicList.add(m);
        }
        return musicMap;
    }

    static List<BestGenres> sortByPlays(Map<String, List<Music>> musicMap) {
        List<BestGenres> genresList = new ArrayList<>();
        for (Map.Entry<String, List<Music>> entry : musicMap.entrySet()) {
            BestGenres genres = new BestGenres(entry.getKey());
            List<Music> music = entry.getValue();
            for (Music m : music) {
                genres.addPlays(m);
            }
            genresList.add(genres);
            Collections.sort(genres.musicList);
        }

        Collections.sort(genresList);
        return genresList;
    }

    static class BestGenres implements Comparable<BestGenres> {
        final String genres;
        List<Music> musicList;
        int totalPlays;

        public BestGenres(String genres) {
            this.genres = genres;
            this.totalPlays = 0;
            this.musicList = new ArrayList<>();
        }

        void addPlays(Music m) {
            this.musicList.add(m);
            this.totalPlays += m.plays;
        }

        @Override
        public int compareTo(BestGenres o) {
            return o.totalPlays - this.totalPlays;
        }
    }

    static class Music implements Comparable<Music> {
        final String genres;
        final int plays;
        final int id;

        public Music(String genre, int plays, int id) {
            this.genres = genre;
            this.plays = plays;
            this.id = id;
        }

        @Override
        public int compareTo(Music o) {
            if (this.plays == o.plays)
                return this.id - o.id;
            return o.plays - this.plays;
        }
    }
}
