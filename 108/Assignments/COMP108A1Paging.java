//
// Note: You are allowed to add additional methods if you need.
// Coded by Prudence Wong 2020-12-15
//
// Name:
// Student ID:
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
// noEvict():
//
// evictFIFO():
//
// evictLFU():
//
// evictLFD():
//

class COMP108A1Paging {


	// no eviction
	// Aim: 
	// do not evict any page
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output noEvict(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		for (int i = 0; i < rSize; i++) {
			boolean foundReq = false;
			for (int j = 0; j < cSize; j++) {
				if (cArray[j] == rArray[i]) {
					foundReq = true;
				}
			}
			if (!foundReq) {
				output.missCount++;
				output.hitPattern += "m";
			} else {
				output.hitCount++;
				output.hitPattern += "h";
			}
		}
		return output;
	}

	private static int findLongestCacheIndex(int[] cacheCycles, int cacheSize) {
		int longestIndex = 0;
		int longestCycleValue = cacheCycles[0];
		for (int i = 1; i < cacheSize; i++) {
			if (cacheCycles[i] > longestCycleValue) {
				longestCycleValue = cacheCycles[i];
				longestIndex = i;
			}
		}
		return longestIndex;
	}
	// evict FIFO
	// Aim: 
	// evict the number present in cache for longest time if next request is not in cache
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input: 
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictFIFO(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		int indexToEvict = 0;
		int[] cacheCycles = new int[cSize];
		for (int i = 0; i < rSize; i++) {
			boolean foundReq = false;
			for (int j = 0; j < cSize; j++) {
				cacheCycles[j]++;
				if (cArray[j] == rArray[i]) {
					foundReq = true;
				}
			}
			if (!foundReq) {
				output.missCount++;
				output.hitPattern += "m";
				indexToEvict = findLongestCacheIndex(cacheCycles, cSize);
				cArray[indexToEvict] = rArray[i];

			} else {
				output.hitCount++;
				output.hitPattern += "h";
			}
		}
		return output;
	}

	// evict LFU
	// Aim:
	// evict the number that is least freently used so far if next request is not in cache
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictLFU(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		return output;
	}

	// evict LFD
	// Aim:
	// evict the number whose next request is the latest
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries	
	static COMP108A1Output evictLFD(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		return output;
	}

}

