#använder graffärgning
class Cast2graph:
    def __init__(self):
        self.edg = [[] for _ in range(4)]
        self.edg[1].append(3)
        self.edg[2].append(3)
        self.v = 3
        self.e = 2
        self.m = 3
        self.uniq_edges = 2
        self.cnt = 2
        self.a = 0
        self.b = 0
        try:
            v_input = int(input())
            e_input = int(input())
            m_input = int(input())
            self.v += v_input
            self.e += e_input
            self.m += m_input
            iso = [0] * (self.v + 1)

            if self.e > 2:
                for i in range(4, self.v + 1):
                    self.edg.append([])
                while self.cnt < self.e:
                    a_input, b_input = map(int, input().split())
                    self.a = a_input
                    self.b = b_input
                    if self.a <= self.b:
                        if (b_input + 3) not in self.edg[a_input + 3]:
                            self.edg[a_input + 3].append(b_input + 3)
                            self.uniq_edges += 1
                    else:
                        if (a_input + 3) not in self.edg[b_input + 3]:
                            self.edg[b_input + 3].append(a_input + 3)
                            self.uniq_edges += 1
                    iso[a_input + 3] = 1
                    iso[b_input + 3] = 1
                    self.cnt += 1
                removed = 0
                for i in range(4, len(iso)):
                    if iso[i] == 0:
                        self.edg[i].append(-1)
                        self.v -= 1
                        iso[i] = removed
                        removed -= 1
                    iso[i] = removed
            else:
                self.v = 3
                self.e = 2
                self.m = 3
            if self.m > self.v:
                self.m = self.v

            # Skriv ut resultatet i rätt format
            print(self.v)
            print(self.uniq_edges)
            print(self.m)
            for i in range(1, 4):
                print(1, i)
            for i in range(4, self.v + 1):
                print(self.m - 3, end=" ")
                for k in range(4, self.m + 1):
                    print(k, end=" ")
                print()
            for i in range(1, len(self.edg)):
                for num in self.edg[i]:
                    if num >= 0:
                        print(2, i + iso[i], num + iso[num])

        except Exception as exception:
            pass


if __name__ == "__main__":
    Cast2graph()
