import re
from bs4 import BeautifulSoup
import requests

def main():
    website_scraped = requests.get("https://starlust.org/how-far-away-is-earth-from-the-sun/")
    soup = BeautifulSoup(website_scraped.text, "html.parser")
    data = soup.find("div", attrs={"class":"elementor-shortcode"})
    new_data = list(map(int, re.findall('\d+', str(data))))
    num = max_num_in_list(new_data)
    print(num)


def max_num_in_list(list):
    max = list[0]
    for a in list:
        if a > max:
            max = a
    return max

main()
