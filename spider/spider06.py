import requests
import time
import xlwt
from bs4 import BeautifulSoup

#  https://fxxkpython.com/python3-web-fxxkpython-spider-tutorial-07.html
def log(*args, **kwargs):
    format = '%Y/%m/%d %H:%M:%D'
    value = time.localtime(int(time.time()))
    dt = time.strftime(format, value)
    with open('./txb.txt','a+',encoding='utf-8') as f:
        print( *args,file=f,  **kwargs)

def get_html(url):
    try:
        r = requests.get(url)
        if(r.status_code == 200):
            return r.text
    except:
        return None


def get_movies(soup,index):
    list = soup.find(class_='grid_view').find_all('li')
    global n

    for i in list:
        movieName = i.find(class_='title').string
        movieIndex = str(index*25 + int(i.find(class_='').string))
        # 优先返回第一个找到的Tag
        movieScore = i.find(class_='rating_num').string
        movieAuthor = i.find('p').text
        id = int(movieIndex)
        mySheet.write(id,0,movieIndex)
        mySheet.write(id,1,movieName)
        mySheet.write(id,2,movieScore)
        mySheet.write(id,3,movieAuthor)
        print()
        log(movieIndex, movieName, movieAuthor, movieScore)





if __name__ == '__main__':

    myWorkbook = xlwt.Workbook()
    mySheet = myWorkbook.add_sheet('A Test Sheet', cell_overwrite_ok=True)
    myStyle = xlwt.easyxf('font: name Times New Roman, color-index red, bold on', num_format_str='#,##0.00')  # 数据格式
    mySheet.write(0, 0, 'index', myStyle)
    mySheet.write(0, 1, 'name', myStyle)
    mySheet.write(0, 2, 'score', myStyle)
    mySheet.write(0, 3, 'author', myStyle)


    for i in range(0,10):
        url = 'https://movie.douban.com/top250?start='+str(i*0)+'&filter='
        html = get_html(url)
        soup = BeautifulSoup(html, 'lxml')
        get_movies(soup,i)
    myWorkbook.save('excelFile10.xls')























