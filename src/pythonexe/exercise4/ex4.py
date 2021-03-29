def total_number_of_a(s, n):
    num_str_a = int(n/len(s))
    rest = int(n%len(s))

    str_with_a = len([t for t in s if 'a'==t])

    total_a = num_str_a *  str_with_a

    if rest !=0:
        for i in range(rest):
            if s[i] == 'a':
                total_a+1

    return total_a